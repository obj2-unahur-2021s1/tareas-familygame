package ar.edu.unahur.obj2.tareas

interface Tarea {

    fun horasNecesarias() : Double

}

class Simple(private val horasEstimadas : Double,
             private val responsable: Empleado,
             private val empleadosAsignados : MutableList<Empleado>,
             private val costoInfraestructura: Int)
    : Tarea {

    override fun horasNecesarias() = this.horasEstimadas / empleadosAsignados.size


}

class Integracion(responsable : Empleado) : Tarea{

    private var tareas = mutableListOf<Tarea>()

    override fun horasNecesarias() = tareas.sumByDouble { it.horasNecesarias() } + (tareas.sumByDouble { it.horasNecesarias() / 8 })
    private fun costoSubTareas() = tareas.sumByDouble { it.costoTarea() }
    private fun bonus() = costoSubTareas() * 0.03


}
