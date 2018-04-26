(ns jobs.csv-test
  (:require [clojure.test :refer :all]
            [jobs.csv :as csv]))

(def expected
  (str "14.0,23.0\n"
       "9.0,12.0"))

(deftest integration-test
  (testing "Reading a csv, will it generate the expected result?"
    (is (= expected
           (csv/evaluate-csv "input.csv")))))
