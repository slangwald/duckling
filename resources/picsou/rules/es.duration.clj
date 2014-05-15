; Durations / Periods

(
  "seconde (unit-of-duration)"
  #"(?i)seg(undo)?s?"
  {:dim :unit-of-duration
   :grain seconds
   :in-width (seconds 1)} ; width of interval when "in 10 secs"

  "minute (unit-of-duration)"
  #"(?i)min(uto)?s?"
  {:dim :unit-of-duration
   :grain minutes
   :in-width (minutes 1)}

  "hour (unit-of-duration)"
  #"(?i)h(ora)?s?"
  {:dim :unit-of-duration
   :grain hours
   :in-width (hours 1)}

  "day (unit-of-duration)"
  #"(?i)d(í|i)as?"
  {:dim :unit-of-duration
   :grain days
   :in-width (days 1)}

  "week (unit-of-duration)"
  #"(?i)semanas?"
  {:dim :unit-of-duration
   :grain weeks
   :in-width (weeks 1)}

  "month (unit-of-duration)"
  #"(?i)mes(es)?"
  {:dim :unit-of-duration
   :grain months
   :in-width (months 1)}
  
  "year (unit-of-duration)"
  #"(?i)a(n|ñ)os?"
  {:dim :unit-of-duration
   :grain years
   :in-width (years 1)}
  
  "<integer> <unit-of-duration>"
  [(integer) (dim :unit-of-duration)]
  {:dim :duration
   :val ((:grain %2) (:val %1))
   :in-width (:in-width %2)} ; used by "in <duration>"

  "in <duration>"
  [#"(?i)en" (dim :duration)]
  (in-duration (:val %2) (:in-width %2))

  "ago <duration>"
  [#"hace" (dim :duration)]
  (in-duration (:val %2) (:in-width %2) -)

)