package org.toy.til.groovy

class GroovyGrammar {

    static void main(String[] args) {

        println "Hello"
        println "oh" /** comment !!*/ + "  lol...."

        //  #! this is Shebang line.  It must be declared by first line.

        def obj = [:]  // maps, using the [:] literal. also list ,using the [] literal.
        obj."world" = "wow..."

        println obj."world"
        println "wow ! dollar expression ::  $obj.world "

        // multi-line

        def tripleQuote = ''' 
            wow ..! 
            oh... ! 
            gooood~~~! 
        '''

        println tripleQuote

        // 이정도만 알아도 spock 을 쓰는데 무리는 없을 듯함.
    }
}
