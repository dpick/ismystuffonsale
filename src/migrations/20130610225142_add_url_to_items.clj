(ns migrations.20130610225142-add-url-to-items
 (:use [korma.db] [korma.core]))

(defn up
  "Migrates the database up to version 20130610225142."
  []
  (exec-raw
    ["ALTER TABLE items
      ADD COLUMN url TEXT NOT NULL"])
  (println "migrations.20130610225142-add-url-to-items up..."))

(defn down
  "Migrates the database down from version 20130610225142."
  []
  (exec-raw
    ["ALTER TABLE items
      DROP COLUMN url"])
  (println "migrations.20130610225142-add-url-to-items down..."))
