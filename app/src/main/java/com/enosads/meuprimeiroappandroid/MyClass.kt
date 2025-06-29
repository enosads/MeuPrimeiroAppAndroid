package com.enosads.meuprimeiroappandroid

import android.content.Context
import java.lang.ref.WeakReference

class MyClass(val context: Context) {
    //...
    private val contextWeakReference= WeakReference(context)

    fun doSomething(){
      contextWeakReference.get()
        // Use the context here
    }
}