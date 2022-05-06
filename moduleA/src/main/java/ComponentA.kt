import dagger.BindsInstance
import dagger.Component

@Component
interface ComponentA {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance classA: ClassA): ComponentA
    }

    val classA: ClassA
}

data class ClassA(val string: String)
