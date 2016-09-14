(def :empty nil)

(def :empty? @"Checks whether a stream is empty"
  nil?
)

(def :head @"Returns the head of a stream"
  (function [:s] {
    (first (s))
  })
)

(def :tail @"Returns the tail of a stream"
  (function [:s] {
    (second (s))
  })
)

(def :foldl @"Foldl for streams"
  (function [:pred :initial-value :s] {
    (if (empty? s)
      { initial-value }
      { (recurse pred (pred initial-value (head s)) (tail s)) }
    )
  })
)

(def :length @"Returns the length of a stream"
  (partial 1 [foldl (function [:z :x] { (+ 1 z) }) 0])
)

(def :map @"Map a predicate to each element of a stream"
  (function [:f :s] {
    (if (empty? s)
      { empty }
      { (function [] { (pair (f (head s)) (map f (tail s))) }) }
    )
  })
)

(def :filter @"Filter elements of a stream"
  (function [:f :s] {
    (def :x (head s))
    (def :t (tail s))

    (def :this recurse)

    (if (f x)
      { (function [] { (pair x (this f t)) }) }
      { (this f t) }
    )
  })
)

(def :take @"Takes n elements from a stream as a list"
  (function [:n :s] {
    (if (<= n 0)
      { nil }
      { (pair (head s) (recurse (- n 1) (tail s))) }
    )
  })
)

(def :take-while @"Takes elements while a predicate is satisfied"
  (function [:f :s] {
    (def :take? (f (head s)))

    (if take?
      { (pair (head s) (recurse f (tail s))) }
      { nil }
    )
  })
)

(def :integers @"Generates an infinite stream of integers"
  (function [] {
    (def :helper (function [:n] {
      (function [] {
        (pair n (helper (+ n 1)))
      })
    }))

    (helper 1)
  })
)

(def :range @"Generates a range of integers"
  (function [:start :end] {
    (if (>= start end)
      { empty }
      {(function [] {
        (pair start (range (+ start 1) end))
      })}
    )
  })
)

(export [:empty :empty? :head :tail :foldl :length :map :filter :take :take-while :integers :range])