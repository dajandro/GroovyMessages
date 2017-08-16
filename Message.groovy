/**
 * Daniel Orozco 13312
 * Messages creator with Groovy
 */

import groovy.xml.MarkupBuilder

class Message{

    String to
    String from
    String body
    def sections = []

    def static make(closure){
        Message message = new Message()
        closure.delegate = message
        closure()
    }

    def to(String to){
        this.to = to
    }

    def from(String from){
        this.from = from
    }

    def body(String body){
        this.body = body
    }

    def methodMissing(String name, args){
        def section = new Section(title: name, body: args[0])
        this.sections << section
    }

    def getXML(){
        doXML(this)
    }

    def getHTML(){
        doHTML(this)
    }

    def getTXT(){
        doTXT(this)
    }

    private static doXML(Message message){
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)
        xml.message(){
            to(message.to)
            from(message.from)
            body(message.body)
            for (section in message.sections)
                "$section.title"(section.body)
        }
        println writer
    }

    private static doHTML(Message message){
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)
        xml.html(){
            head{
                title("Message")
            }
            body{
                h1("Message")
                h2("To: ${message.to}")
                h3("From: ${message.from}")
                p(message.body)
                for (section in message.sections){
                    p{ b(section.title.toUpperCase()) }
                    p(section.body)
                }
            }
        }
        println writer
    }

    private static doTXT(Message message){
        String template = "Message\nTo: ${message.to}\nFrom: ${message.from}\n${message.body}\n"
        def sects = ""
        for (section in message.sections)
            sects += section.title.toUpperCase() + "\n" + section.body + "\n"
        template += sects
        println template
    }

}
