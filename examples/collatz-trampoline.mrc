(def trampoline (function (f)
                  (let (result f)
                    (do (
                      (while (function? result) (set! result (result)))
                      result
                    )))))

(def collatz-size (function (n)
                    (let (helper (function (n size)
                                   (if (= n 1)
                                       (+ 1 size)
                                       (function () (helper (if (even? n)
                                                                (/ n 2)
                                                                (+ (* 3 n) 1))
                                                            (+ size 1))))))
                      (trampoline (function () (helper n 0))))))

(def my-range (function (v1 v2)
                (let (helper (function (v1 v2 l)
                               (if (< v2 v1)
                                   l
                                   (function () (helper v1 (- v2 1) (cons v2 l))))))
                  (trampoline (function () (helper v1 v2 nil))))))

(def my-length (function (l)
                 (let (helper (function (l size)
                                (if (nil? l)
                                    size
                                    (function () (helper (tail l) (+ size 1))))))
                   (trampoline (function () (helper l 0))))))

(def my-list-max (function (xs)
                   (let (helper (function (xs m)
                                  (if (= (my-length xs) 1)
                                      (max (head xs) m)
                                      (function () (helper (tail xs) (max (head xs) m))))))
                     (trampoline (function () (helper (tail xs) (head xs)))))))

(def my-reverse (function (xs)
                  (let (helper (function (xs acc)
                                 (if (nil? xs)
                                     acc
                                     (function () (helper (tail xs) (cons (head xs) acc))))))
                    (trampoline (function () (helper xs nil))))))

(def my-map (function (f l)
              (let (helper (function (list acc)
                             (if (nil? list)
                                 acc
                                 (function () (helper (tail list) (cons (f (head list)) acc))))))
                (my-reverse (trampoline (function () (helper l nil)))))))

(def max-n 10000)

(print (my-list-max (my-map collatz-size (my-range 1 max-n))))
