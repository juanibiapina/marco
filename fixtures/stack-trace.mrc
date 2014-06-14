(def :f (function [] { x })) // line 1

(def :g (function [] { (f) })) // line 3

(def :h (function [] { (g) })) // line 5

(h) // line 7