(ns learning.core
  (:gen-class))
; Highlight core operations in Clojure

; (def *binding* *value)
; create a global binding to a value
(def x 10)
(def mylist '(1 2 3 4 5 6 7 8 9 10 11 12 13 14 15))

(defn mysecond [coll]
  (first (next coll)))

(defn myfind [x coll]
  (if (nil? coll)
    false
    (if (= x (first coll))
      true
      (myfind x (next coll)))))

(defn mysome [f coll]
  (if (= 0 (count coll))
    false
    (if (f (first coll))
      true
      (mysome f (next coll)))))

(defn myevens [coll]
  (if (= 0 (count coll))
    nil
    (if (even? (first coll))
      (cons (first coll) (myevens (next coll)))
      (myevens (next coll)))))

(defn myfilter [f? coll]
  (if (= 0 (count coll))
    nil
    (if (f? (first coll))
      (cons (first coll) (myfilter f? (next coll)))
      (myfilter f? (next coll)))))


(defn dart[] (list (rand) (rand)))
(defn is-hit? [d] (>= 1 (+ (* (first d) (first d)) (* (second d) (second d)))))
(defn throw-darts [n] (take n (repeatedly dart)))
(defn count-hits [n] (count (filter #(is-hit? %) (throw-darts n))))
(defn pi-seq [n] (* 4 (/ (count-hits n) (double n))))

(defn pi-par [n]
  (let [hits (reduce + (pmap #(if (is-hit? %) 1 0) (throw-darts n)))]
    (* 4 (/ hits (double n)))))

(defn -main
  [& args]

  ; (if *condition* *true-clause* *false-clause (optional)*)
  ; conditional evaluation
  (println (if (= x 2) "Yes" "No")) ; evaluates to?

  ; (cond *condition1* *true1* *condition2* *true2* ... :else *else*)
  ; more flexible if-elseif-elseif-else pattern
  (println (cond
             (= x 2) "First"
             (= x 4) "Second"
             (>= x 4) "Third"
             :else "Else"))

  ; (when *condition* *clause*)
  ; "If" without an "else".
  ; What does this evaluate to when the condition is false?
  ; Remember, every expression must evaluate to a value...
  (println (when (= x 5) "When!"))

  ; (and *condition1* *condition2* ...)
  ; logical and
  (println (when (and (< 0 x) (< x 11)) "And!")))
  ; likewise or, not