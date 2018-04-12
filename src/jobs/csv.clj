(ns jobs.csv
  (:require [clojure.java.io :as io]
            [clojure.tools.logging :as log]
            [clojure.string :as string]
            [windfall.util :as util])
  (:gen-class))

#_(defn- update-data-structure [m v]
  (if (empty? v)
    m
    (recur update-data-structure)))

(defn -main [& args]
  (log/info "Starting!")

  (->> "input.csv"
       io/resource
       slurp
       (#(clojure.string/split % #"\n"))
       (map #(clojure.string/split % #","))
       (map-indexed hash-map)
       util/print-it)


  (log/info "Finished!"))
