import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.asPromise
import kotlinx.coroutines.async
import kotlinx.coroutines.await
import kotlin.js.Promise

@JsModule("axios")
@JsNonModule
external object Axios {
    fun get(path: String): Promise<String>
}

@JsName("getId")
@JsExport
@ExperimentalJsExport
@DelicateCoroutinesApi
fun exportedGetId(): Promise<String> = GlobalScope.async { getId() }.asPromise()

@JsName("internalGetId")
actual suspend fun getId(): String =
    Axios.get("https://httpbin.org/uuid").await()
