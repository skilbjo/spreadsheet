(defproject windfall "0.1.0"
  :uberjar-name "app.jar"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/tools.logging "0.4.0"]
                 [org.slf4j/slf4j-log4j12 "1.6.4"]]
  :source-paths ["src"]
  :profiles {:dev {:plugins [[lein-cljfmt "0.5.7"]
                             [lein-environ "1.1.0"]]}
             :uberjar {:aot :all}}
  :target-path "target/%s"
  :main ^:skip-aot hipmunk-clj.routes
  :jvm-opts ["-Duser.timezone=UTC"
             ; Same JVM options as deploy/bin/run-job uses in production
             "-Xms256m"
             "-Xmx512m"
             "-XX:MaxMetaspaceSize=128m"
             ; https://clojure.org/reference/compilation
             "-Dclojure.compiler.direct-linking=true"
             ; https://stackoverflow.com/questions/4659151/recurring-exception-without-a-stack-trace-how-to-reset
             "-XX:-OmitStackTraceInFastThrow"
             ; https://stackoverflow.com/questions/42651420/how-to-find-non-heap-space-memory-leak-in-java
             "-XX:-HeapDumpOnOutOfMemoryError"])

