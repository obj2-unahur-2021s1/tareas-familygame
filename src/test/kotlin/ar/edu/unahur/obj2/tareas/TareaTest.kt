package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  describe("Una tarea") {

      val carlos = Empleado(100.0)
      val agustin = Empleado(80.0)
      val facundo = Empleado(40.0)
      val lucia = Empleado(50.0)
      val liliana = Empleado(90.0)

      val empleadosAsignados = mutableSetOf(agustin,facundo,lucia,liliana)
      val empleadosAsignados2 = mutableSetOf(carlos,facundo,lucia,liliana)

      val tareaSimple = Simple(50.0, carlos, empleadosAsignados, 500)
      val tareaSimple2 = Simple(60.0, agustin, empleadosAsignados2, 400)

      val tareaIntegracion = Integracion (agustin)
      tareaIntegracion.tareas.add(tareaSimple)
      tareaIntegracion.tareas.add(tareaSimple2)

      it("Consultar nomina de empleados de una tarea simple"){
          tareaSimple.nominaEmpleados().shouldContainAll(carlos,agustin,facundo,lucia,liliana)
      }

      it ("Consultar nomina de empleados de una tarea integracion"){
          tareaIntegracion.nominaEmpleados().shouldContainExactlyInAnyOrder(carlos,agustin,facundo,lucia,liliana)
      }

      it("Horas necesarias para finalizar una tarea simple"){
          tareaSimple.horasNecesarias().shouldBe(12.5)
      }

      it("Horas necesarias para finalizar una tarea de integracion con dos tarea simples"){
          tareaIntegracion.horasNecesarias().shouldBe(30.9375)
      }

      it("Costo de una tarea simple"){
          tareaSimple.costoTarea().shouldBe(18500)
      }

      it("Costo de una tarea de integracion con dos tareas simples"){
          tareaIntegracion.costoTarea().shouldBe(41715)
      }
  }
})
