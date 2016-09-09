(def :cons @"Creates a list"
  (function [:head :tail] {
    (with-meta (pair head tail) #{:length (+ 1 ((meta tail) :length))})
  })
)

(def :head @"Returns the head of a list"
  first
)

(def :tail @"Returns the tail of a list"
  second
)

(def :length @"Determines the length of a list"
  (function [:list] {
    ((meta list) :length)
  })
)

(def :list? @"Checks whether something is a list"
  (function [:list] {
    (if (nil? list) { true } {
      (if (pair? list) {
        (recurse (tail list))
      } {
        false
      })
    })
  })
)

(def :foldl @"Left fold"
  (function [:pred :initial-value :list] {
    (if (nil? list)
      { initial-value }
      { (recurse pred (pred initial-value (head list)) (tail list)) }
    )
  })
)

(def :reverse @"Reverses a list"
    (partial 1 [foldl (flip cons) []])
)

(def :foldr @"Right fold"
  (function [:pred :initial-value :list] {
    (foldl (flip pred) initial-value (reverse list))
  })
)

(def :append @"Appends two lists"
  (function [:l1 :l2] {
    (foldr cons l2 l1)
  })
)

(def :map @"Map function"
  (function [:f :list] {
    (foldr (function [:x :z] {
      (cons (f x) z)
    }) [] list)
  })
)

(def :filter @"Filter function"
  (function [:f :list] {
    (foldr (function [:x :acc] {
      (if (f x)
        { (cons x acc) }
        { acc }
      )
    }) [] list)
  })
)

(def :any @"Checks whether a predicate is true for any element of a list"
  (function [:f :list] {
    (if (nil? list) { false } {
      (if (f (head list)) { true } {
        (recurse f (tail list))
      })
    })
  })
)

(def :flatten @"Flattens a list"
  (function [:l] {
    (def :helper (function [:l :acc] {
        (if (nil? l)
          { acc }
          {
            (def :x (head l))
            (def :xs (tail l))

            (if (list? x)
              { (recurse (append x xs) acc) }
              { (recurse xs (cons x acc)) })
          })
    }))

    (reverse (helper l []))
  })
)

(export [:cons :length :list? :head :tail :foldl :reverse :foldr :append :map :filter :any :flatten])
