(def :max (function [:v1 :v2] { (if (> v1 v2) {v1} {v2}) }))

(def :map (function [:f :l] {
           (if (nil? l)
             { nil }
             { (cons (f (head l)) (recurse f (tail l))) }) }))


(def :even? (function [:v] { (= (% v 2) 0) }))

(def :filter (function [:predicate :list] {
              (if (nil? list)
                  {nil}
                  {(if (predicate (head list))
                       { (cons (head list) (recurse predicate (tail list))) }
                       { (recurse predicate (tail list)) })} ) }))

(def :list-max (function [:xs] {
                (if (= (length xs) 1)
                    { (head xs) }
                    { (max (head xs) (recurse (tail xs))) }) }))

(def :range (function [:v1 :v2] {
             (if (= v1 v2)
                 { nil }
                 { (cons v1 (recurse (+ v1 1) v2)) }) }))
