package ar.edu.unahur.obj2.tareas

class Empleado (private val dineroPorHora : Double) {

    fun calcularSalario(cantidadHorasTrabajadas: Double)  = cantidadHorasTrabajadas * dineroPorHora
}