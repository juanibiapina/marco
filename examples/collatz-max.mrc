(def :collatz (function [n]
                       (if (= n 1)
                           (cons 1 nil)
                           (cons n
                                 (if (even? n)
                                     (collatz (/ n 2))
                                     (collatz (+ (* 3 n) 1)))))))

(def :max-n 2500) // 2600 causes stackoverflow

(print (list-max (map length (map collatz (range 1 (+ max-n 1))))))
