import dagger.Component
import javax.inject.Inject

@Component(
    dependencies = [ComponentA::class]
)
interface ComponentB {

    @Component.Factory
    interface Factory {
        fun create(componentA: ComponentA): ComponentB
    }

/*
    val classA: ClassA
*/


    val classB: ClassB

}

data class ClassB @Inject constructor(private val classA: ClassA)

fun ComponentB.Factory.createWithA() = create(
    DaggerComponentA.factory().create(ClassA("A"))
)
