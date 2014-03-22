(def :collatz (function [:n] {
                       (if (= n 1)
                           (cons 1 nil)
                           (cons n
                                 (if (even? n)
                                     (recurse (/ n 2))
                                     (recurse (+ (* 3 n) 1))))) }))

(print (collatz 6))
