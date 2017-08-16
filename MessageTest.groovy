/**
 * Daniel Orozco 13312
 * Messages creator with Groovy
 */

class MessageTest extends GroovyTestCase{
    void testXML(){
        Message.make{
            to "Maestro 1"
            from "Promo 17"
            body "Deje de poner tareas por favor"
            idea "Los Microservicios son la onda"
            request "Queremos sacar 100"
            XML
        }
    }

    void testHTML(){
        Message.make{
            to "Maestro 1"
            from "Promo 17"
            body "Deje de poner tareas por favor"
            idea "Los Microservicios son la onda"
            request "Queremos sacar 100"
            HTML
        }
    }

    void testTXT(){
        Message.make{
            to "Maestro 1"
            from "Promo 17"
            body "Deje de poner tareas por favor"
            idea "Los Microservicios son la onda"
            request "Queremos sacar 100"
            TXT
        }
    }
}
