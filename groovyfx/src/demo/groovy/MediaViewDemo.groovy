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

GroovyFX.start { primaryStage -> 
    def sg = new SceneGraphBuilder(primaryStage)
    def mp = null

    sg.stage(title: "GroovyFX MediaView Demo", width: 400, height:300, visible: true, resizable: true) {
         scene(fill: groovyblue, root: stackPane()) {
                 mediaView(fitWidth: 400, fitHeight: 300, preserveRatio: true, onError: { println "Error"}) {
                     mp = player(cycleCount: 100, autoPlay: false, 
                                 source: "http://www.longtailvideo.com/jw/upload/bunny.flv",
                                 onError:  {println "Media Error"},
                                 onHalted:{ println "Media Halted"},
                                 onPaused: {println "Media Paused"},
                                 onPlaying:{println "Media Playing"},
                                 onReady:  {println "Media Ready"},
                                 onStalled:{println "Media Stalled"},
                                 onRepeat: {println "Media Repeat"} )
                 }
         }
    }
    mp.play()
    System.out.println(mp);
}
