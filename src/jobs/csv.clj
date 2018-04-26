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

(defn add-spreadsheet-names [seq]
  " Takes in a sequence, (['B2+2' 'A1+A2'] ['B2-3' '7+5'])
    Returns a map: {:a1 'b2+2'
                    :a2 'a1+a2'
                    :b1 'b2-3'
                    :b2 '7+5' "
  (let [alphabet (seq "abcdefghijklmnopqrstuvwxyz")]
    (->> seq
         (map-indexed hash-map))))

(defn evaluate-csv [file]
  (->> file
       io/resource
       slurp
       (#(clojure.string/split % #"\n"))    ; split up rows
       (map #(clojure.string/split % #",")) ; split up cells
       util/print-it
       add-spreadsheet-names
       #_(map-indexed hash-map)))

(defn -main [& args]
  (log/info "Starting!")

  (-> "input.csv"
      evaluate-csv
      util/print-it)

  (log/info "Finished!"))
