package org.microservices.master.restfulwebservices.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.util.*
import java.util.Locale
import javax.servlet.http.HttpServletRequest


@Configuration
class CustomLocaleResolver: WebMvcConfigurer, AcceptHeaderLocaleResolver() {

    var LOCALES: MutableList<Locale> = Arrays.asList(
            Locale("en"),
            Locale("fr"))

    override fun resolveLocale(request: HttpServletRequest): Locale {
        val headerLang = request.getHeader("Accept-Language")
        return if (headerLang == null || headerLang.isEmpty()) Locale.getDefault()
        else Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES)
    }

    @Bean
    fun messageSource(): ResourceBundleMessageSource? {
        val rs = ResourceBundleMessageSource()
        rs.setBasename("messages")
        rs.setDefaultEncoding("UTF-8")
        rs.setUseCodeAsDefaultMessage(true)
        return rs
    }

    /**
     * * @return default Locale set by the user
     */
    @Bean(name = ["localeResolver"])
    fun localeResolver(): LocaleResolver? {
        val slr = SessionLocaleResolver()
        slr.setDefaultLocale(Locale.US)
        return slr
    }

    /**
     * an interceptor bean that will switch to a new locale based on the value of the language parameter appended to a request:
     *
     * @param registry
     * @language should be the name of the request param i.e  localhost:8010/api/get-greeting?language=fr
     *
     *
     * Note: All requests to the backend needing Internationalization should have the "language" request param
     */
    override fun addInterceptors(registry: InterceptorRegistry) {
        val localeChangeInterceptor = LocaleChangeInterceptor()
        localeChangeInterceptor.paramName = "language"
        registry.addInterceptor(localeChangeInterceptor)
    }
}