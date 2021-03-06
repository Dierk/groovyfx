/*
* Copyright 2011 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License")
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/


import groovyx.javafx.GroovyFX
import groovyx.javafx.SceneGraphBuilder
import javafx.animation.Transition

GroovyFX.start { primaryStage ->
    def sg = new SceneGraphBuilder(primaryStage)
    Transition rectTransition = null

    def testTransition = sg.fadeTransition(5.s, delay: 500.ms, from: 1.0, to: 0.0, onFinished: { println "done" })

    sg.stage(title: "GroovyFX Transition Demo", width: 400, height: 300, visible: true, resizable: true) {
        scene(fill: groovyblue) {
            rectangle(x: 20, y: 20, width: 100, height: 50, fill: blue) {
                rectTransition = transition(testTransition)
            }
        }
    }
    rectTransition.playFromStart()
}

