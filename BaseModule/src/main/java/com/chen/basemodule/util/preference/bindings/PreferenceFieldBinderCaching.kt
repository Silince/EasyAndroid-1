package com.chen.basemodule.util.preference.bindings

import android.content.SharedPreferences
import com.chen.basemodule.util.preference.PreferenceHolder
import java.lang.reflect.Type
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

internal class PreferenceFieldBinderCaching<T : Any>(
        private val clazz: KClass<T>,
        private val type: Type,
        private val default: T,
        private val key: String?
) : ReadWriteProperty<PreferenceHolder, T>, Clearable {

    override fun clear(thisRef: PreferenceHolder, property: KProperty<*>) {
        setValue(thisRef, property, default)
    }

    override fun clearCache() {
        field = null
    }

    var field: T? = null

    override operator fun getValue(thisRef: PreferenceHolder, property: KProperty<*>): T =  thisRef.preferences.getValue(property)

    override fun setValue(thisRef: PreferenceHolder, property: KProperty<*>, value: T) {
        if (value == field) return
        field = value
        thisRef.preferences.edit().apply { putValue(clazz, value, getKey(key, property)) }.apply()
    }

    private fun SharedPreferences.getValue(property: KProperty<*>): T {
        val key = getKey(key, property)
        return getFromPreference(clazz, type, default, key) as T
    }
}