**3.2 Hands-on 2: The Interrupted Counter**
**Goal:** Fix a counter app that resets to zero whenever the screen is rotated.
**The “Sabotage” Code (Intentional Crash):** Integrate this code into your onCreate.
You must fix the crash and explain why it happened in your README.

// SABOTAGE : This will likely cause a NullPointerException if not handled .
TextView counterDisplay = null ;
counterDisplay . setText ("0") ;

**Hint: State Preservation** Use these methods to save and restore your counter value
during the “Destroy-and-Recreate” cycle of a rotation.

@Override
protected void onSaveInstanceState ( Bundle outState ) {
super . onSaveInstanceState ( outState ) ;
outState . putInt (" COUNT_KEY ", mCounter ) ;
}

@Override
protected void onRestoreInstanceState ( Bundle savedInstanceState ) {
super . onRestoreInstanceState ( savedInstanceState ) ;
mCounter = savedInstanceState . getInt (" COUNT_KEY ") ;
myTextView . setText ( String . valueOf ( mCounter ) ) ;
}

**Why does it crashed?**
The reason behind the problem existing in the first place was that the TextView 
object is null, and the next line of code tries to call setText() function which triggers 
NullPointerException.


**Solution:**
The TextView variable is assigned and linked to the actual UI component with the use of findViewById().
Implementing a null check, ensures that the application will remain stable even if the view is nowhere 
to be found or existed.


**Why does the counter reset?**
It is because in every activity lifecycle, it will go under the process Recreate/Destory 
phase which destroys local variables including the counter. Since screen rotation is a Configuration 
Change, it will affect its instance and start from scratch. 

**Solution:**
Using both onSaveInstanceState and onRestoredInstanceState for the local variable to be saved into a key 
renamed as "COUNT_KEY". Then it remembers the saved value and reassigns it once again to the counter 
variable, then updating UI using setText().
