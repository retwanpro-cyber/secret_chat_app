package com.radwan.nova.data.remote

import io.github.jan_tennert.supabase.createSupabaseClient
import io.github.jan_tennert.supabase.gotrue.Auth
import io.github.jan_tennert.supabase.postgrest.Postgrest
import io.github.jan_tennert.supabase.realtime.Realtime

object SupabaseClientProvider {

    private const val SUPABASE_URL = "https://xomovlxjqqikrpughzof.supabase.co"
    private const val SUPABASE_KEY = "sb_publishable_KiXwEcu0Di9HyFKSbAA_6g_enfXlJJI"

    val client = createSupabaseClient(
        supabaseUrl = SUPABASE_URL,
        supabaseKey = SUPABASE_KEY
    ) {
        install(Auth)
        install(Postgrest)
        install(Realtime)
    }
}
