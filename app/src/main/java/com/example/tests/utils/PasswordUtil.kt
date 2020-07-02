package com.example.tests.utils

class PasswordUtil {
    companion object {
        fun isStrongPassword(value: String) : Boolean {
            if (value.length < 7) return false
            if (!value.matches(Regex(".*[A-Z].*"))) return false
            if (!value.matches(Regex(".*[0-9].*"))) return false

            return true
        }
    }
}