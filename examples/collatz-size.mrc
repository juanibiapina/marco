(def :collatz-size (function [:n] {
                    (let [:helper (function [:n :size] {
                                    (if (= n 1)
                                        (+ 1 size)
                                        (recurse (if (even? n)
                                                     (/ n 2)
                                                     (+ (* 3 n) 1))
                                                 (+ size 1))) })]
                      (helper n 0)) }))

(def :collatz-max (function [:n] {
                   (let [:helper (function [:n :current-max] {
                                   (if (= n 1)
                                       (max 1 current-max)
                                       (recurse (- n 1) (max current-max (collatz-size n)))) })]
                     (helper n 0)) }))

(print (collatz-max 100000))
