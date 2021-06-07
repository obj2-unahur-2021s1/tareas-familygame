package ar.edu.unahur.obj2.tareas

interface Tarea {

    fun horasNecesarias() : Double
    fun costoTarea() : Double
    fun nominaEmpleados(): MutableSet<Empleado>
}

class Simple(private val horasEstimadas : Double,
             private val responsable: Empleado,
             private val empleadosAsignados : MutableSet<Empleado>,
             private val costoInfraestructura: Int)
    : Tarea {

    override fun horasNecesarias() = this.horasEstimadas / empleadosAsignados.size
    override fun costoTarea() = this.costoInfraestructura + empleadosAsignados.sumByDouble { it.calcularSalario(horasEstimadas)} + responsable.calcularSalario(horasEstimadas)
    override fun nominaEmpleados(): MutableSet<Empleado> {
        val nominaEmpleados = this.empleadosAsignados
        nominaEmpleados.add(responsable)
        return nominaEmpleados
    }
}

class Integracion(private val responsable : Empleado) : Tarea{

    var tareas = mutableListOf<Tarea>()

    override fun horasNecesarias() = tareas.sumByDouble { it.horasNecesarias() } + (tareas.sumByDouble { it.horasNecesarias() / 8 })
    private fun costoSubTareas() = tareas.sumByDouble { it.costoTarea() }
    private fun bonus() = costoSubTareas() * 0.03
    override fun costoTarea() = costoSubTareas() + bonus()
    override fun nominaEmpleados(): MutableSet<Empleado> {
        val nominaEmpleados = tareas.flatMap { it.nominaEmpleados() }.toMutableSet()
        nominaEmpleados.add(responsable)
        return nominaEmpleados
    }
}
