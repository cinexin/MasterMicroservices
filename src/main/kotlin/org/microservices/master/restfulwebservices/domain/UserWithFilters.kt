package org.microservices.master.restfulwebservices.domain

import com.fasterxml.jackson.annotation.JsonFilter
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
import org.springframework.http.converter.json.MappingJacksonValue

@JsonFilter("UserDynaFilter")
data class UserWithFilters(
        val id: String,

        val name: String,

        // @JsonIgnore
        val password: String
) {
    constructor(): this("sample-id", "sample-name", "sample-password")

    companion object {
        fun getSampleList(): List<UserWithFilters> {
            return listOf(
                    UserWithFilters("id-1", "name-1", "password-1"),
                    UserWithFilters("id-2", "name-2", "password-2"),
                    UserWithFilters("id-3", "name-3", "password-3")
            )
        }

        private fun dynaFilterProvider(vararg fields: String): SimpleFilterProvider {
            val propertiesFilter = SimpleBeanPropertyFilter.filterOutAllExcept(*fields)
            return SimpleFilterProvider().addFilter("UserDynaFilter", propertiesFilter)
        }

        fun toDynaFilterMapping(userWithFilters: UserWithFilters): MappingJacksonValue {
            val mapping = MappingJacksonValue(userWithFilters)
            mapping.filters = dynaFilterProvider("id", "name")
            return mapping
        }

        fun toDynaFilterMapping(userWithFiltersList: List<UserWithFilters>): MappingJacksonValue {
            val mapping = MappingJacksonValue(userWithFiltersList)
            mapping.filters = dynaFilterProvider("name")
            return mapping
        }
    }
}