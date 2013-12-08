(def head first)

(def tail second)

(def and (macro (e1 e2)
           (if (eval e1) (eval e2) false)))

(def or (macro (e1 e2)
          (let (v1 (eval e1))
            (if v1 v1 (eval e2)))))

(def list? (function (l)
             (or (nil? l)
                 (and (pair? l)
                      (list? (tail l))))))

(def length (function (l)
              (if (nil? l)
                0
                (+ 1 (length (tail l))))))

(def list-max (function (xs)
                (if (= (length xs) 1)
                    (head xs)
                    (max (head xs) (list-max (tail xs))))))

(def map (function (f l)
           (if (nil? l)
             nil
             (cons (f (head l)) (map f (tail l))))))


(def even? (function (v) (= (% v 2) 0)))

(def max (function (v1 v2) (if (> v1 v2) v1 v2)))

(def range (function (v1 v2)
             (if (= v1 v2)
                 nil
                 (cons v1 (range (+ v1 1) v2)))))