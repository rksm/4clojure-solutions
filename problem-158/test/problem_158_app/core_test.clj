(ns problem-158.core-test
  (:require [clojure.test :refer :all]
            [problem-158.core :refer :all]))

(deftest test-uncurry-makro-0
  (testing "0"
    (is (= 10 ((uncurry (fn [a]
                  (fn [b]
                    (fn [c]
                      (fn [d]
                        (+ a b c d))))))
            1 2 3 4)))))



(deftest test-uncurry-makro-1
  (testing "1"
    (is (= 24 ((uncurry (fn [a]
                          (fn [b]
                            (fn [c]
                              (fn [d]
                                (* a b c d))))))
               1 2 3 4)))))

(deftest test-uncurry-makro-2
  (testing "2"
    (is (= 25 ((uncurry (fn [a]
                          (fn [b]
                            (* a b))))
               5 5)))))

;; -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

(deftest test-var-args-call-0
  (testing "var-args-call-0"
    (is (= 10 ((var-args-call (fn [a]
                                (fn [b]
                                  (fn [c]
                                    (fn [d]
                                      (+ a b c d))))))
               1 2 3 4)))))



(deftest test-var-args-call-1
  (testing "var-args-call-1"
    (is (= 24 ((var-args-call (fn [a]
                                (fn [b]
                                  (fn [c]
                                    (fn [d]
                                      (* a b c d))))))
               1 2 3 4)))))

(deftest test-var-args-call-2
  (testing "var-args-call-2"
    (is (= 25 ((var-args-call (fn [a]
                                (fn [b]
                                  (* a b))))
               5 5)))))
