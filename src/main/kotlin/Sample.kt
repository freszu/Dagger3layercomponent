import dagger.Component
import javax.inject.Inject

@Component(dependencies = [ComponentB::class])
interface ComponentC {

    @Component.Factory
    interface Factory {
        fun create(
            componentB: ComponentB
        ): ComponentC
    }

    fun inject(someActivity: SomeActivity)

}

class SomeActivity {

    @Inject
    lateinit var classB: ClassB

/*    @Inject
    lateinit var classA: ClassA*/

}

fun main() {
    val component = DaggerComponentC.factory().create(
        // just in case when A is not reachable this extension calls it in module B
        DaggerComponentB.factory().createWithA()
    )

    val activity = SomeActivity()

    component.inject(activity)

    println("trackerUser: ${activity.classB}")
}
