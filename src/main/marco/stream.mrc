(def :list (require "list"))

(def :empty nil)

(def :empty? @"Checks whether a stream is empty"
  (function [:s] {
    (nil? s)
  })
)

(def :stream? @"Checks whether an object is a stream"
  (function [:s] {
    (or
      { (empty? s) }
      {
        (and
          { (pair? s) }
          { (function? (second s)) }
        )
      }
    )
  })
)

(def :cons @"Builds a stream"
  (function [:e :s] {
    (pair e s)
  })
)

(def :head @"Returns the head of a stream"
  (function [:s] {
    (first s)
  })
)

(def :tail @"Returns the tail of a stream"
  (function [:s] {
    ((second s))
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

(def :filter @"Filter elements of a stream"
  (function [:f :s] {
    (def :x (head s))
    (def :t (tail s))

    (def :this recurse)

    (if (f x)
      { (cons x (function [] { (this f t) })) }
      { (this f t) }
    )
  })
)

(def :take @"Takes n elements from a stream as a list"
  (function [:n :s] {
    (if (<= n 0)
      { nil }
      { (list.cons (head s) (recurse (- n 1) (tail s))) }
    )
  })
)

(def :take-while @"Takes elements while a predicate is satisfied"
  (function [:f :s] {
    (def :take? (f (head s)))

    (if take?
      { (list.cons (head s) (recurse f (tail s))) }
      { nil }
    )
  })
)

(def :integers @"Generates an infinite stream of integers"
  (function [] {
    (def :helper (function [:n] {
      (cons n (function [] { (helper (+ n 1)) }))
    }))

    (helper 1)
  })
)

(def :range @"Generates a range of integers"
  (function [:start :end] {
    (if (>= start end)
      { empty }
      {
        (cons start (function [] {
          (range (+ start 1) end)
        }))
      }
    )
  })
)

(export [:empty :empty? :stream? :cons :head :tail :foldl :length :filter :take :take-while :integers :range])