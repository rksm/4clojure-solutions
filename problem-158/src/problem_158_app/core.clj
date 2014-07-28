(ns problem-158.core
  (:gen-class))

(defmacro uncurry
  [form]
  (loop [step 0
         vars []
         inner-form form]
    (if (and (coll? inner-form) (= 'fn (first inner-form)))
      (let [[_ args body] inner-form]
        (recur (inc step) (apply conj vars args) body))
      `(fn ~vars ~inner-form))))

(defn var-args-call
  [func]
  (fn [& args]
    (reduce (fn [current-fn arg] (current-fn arg))
     func args)))
