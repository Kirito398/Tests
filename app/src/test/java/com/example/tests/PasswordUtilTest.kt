package com.example.tests

import com.example.tests.utils.PasswordUtil
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Test

class PasswordUtilTest {

    @Test
    fun shouldHaveMoreThanSixSymbols() {
        assertFalse(PasswordUtil.isStrongPassword("A1"))
        assertFalse(PasswordUtil.isStrongPassword("Mole12"))

        assertTrue(PasswordUtil.isStrongPassword("Moleskin123"))
    }

    @Test
    fun shouldHaveAtLeastOneDigit() {
        assertFalse(PasswordUtil.isStrongPassword("Dictionary"))

        assertTrue(PasswordUtil.isStrongPassword("Dictionary1"))
        assertTrue(PasswordUtil.isStrongPassword("Dictionary123456789"))
    }

    @Test
    fun shouldHaveAtLeastOneCapitalLetter() {
        assertFalse(PasswordUtil.isStrongPassword("computer12345"))

        assertTrue(PasswordUtil.isStrongPassword("compUter123345"))
        assertTrue(PasswordUtil.isStrongPassword("COMPUTER12345"))
    }
}