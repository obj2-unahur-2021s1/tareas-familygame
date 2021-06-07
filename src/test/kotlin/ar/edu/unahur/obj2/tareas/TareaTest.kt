package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec

class TareaTest : DescribeSpec({
  describe("Una tarea") {
      val carlos = Empleado(100.0)
      val agustin = Empleado(80.0)
      val facundo = Empleado(40.0)
      val lucia = Empleado(50.0)
      val liliana = Empleado(90.0)
      val empleadosAsignados = mutableSetOf<Empleado>(agustin,facundo,lucia,liliana)
      val tareaSimple = Simple(50.0, carlos, empleadosAsignados, 500)
      it(" Consultar nomina de empleados de una tarea simple"){
          tareaSimple.nominaEmpleados().shouldContainAll(carlos,agustin,facundo,lucia,liliana)

      }
      it ("Consultar nomina de empleados de una tarea integracion"){
          val empleadosAsignados2 = mutableSetOf<Empleado>(carlos,facundo,lucia,liliana)
          val tareaSimple2 = Simple(60.0, agustin, empleadosAsignados2, 400)
          val tareaIntegracion = Integracion (agustin)
          tareaIntegracion.tareas.add(tareaSimple)
          tareaIntegracion.tareas.add(tareaSimple2)
          tareaIntegracion.nominaEmpleados().shouldContainExactlyInAnyOrder(carlos,agustin,facundo,lucia,liliana)
      }
  }
})
