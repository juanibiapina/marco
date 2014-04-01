(def :collatz (function [:n] {
                       (if (= n 1)
                           { (cons 1 nil) }
                           { (cons n
                                   (if (even? n)
                                       { (recurse (/ n 2)) }
                                       { (recurse (+ (* 3 n) 1)) })) }) }))

(def :max-n 2300) // 2400 causes stackoverflow

(print (list-max (map length (map collatz (range 1 (+ max-n 1))))))
