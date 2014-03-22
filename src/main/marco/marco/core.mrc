(def head first)

(def tail second)

(def max (function [:v1 :v2] (if (> v1 v2) v1 v2)))

(def map (function [:f :l]
           (if (nil? l)
             nil
             (cons (f (head l)) (map f (tail l))))))


(def even? (function [:v] (= (% v 2) 0)))

(def filter (function [:predicate :list]
              (if (nil? list)
                  nil
                  (if (predicate (head list))
                      (cons (head list) (filter predicate (tail list)))
                      (filter predicate (tail list))))))

(def list-max (function [:xs]
                (if (= (length xs) 1)
                    (head xs)
                    (max (head xs) (list-max (tail xs))))))

(def range (function [:v1 :v2]
             (if (= v1 v2)
                 nil
                 (cons v1 (range (+ v1 1) v2)))))