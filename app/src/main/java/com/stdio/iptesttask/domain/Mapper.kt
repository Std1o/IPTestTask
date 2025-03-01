package com.stdio.iptesttask.domain

interface Mapper<I, O> {
    fun map(input: I): O
}