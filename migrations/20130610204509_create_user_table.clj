(ns migrations.20130610204509-create-user-table
 (:use [korma.db] [korma.core]))

(defn up
  "Migrates the database up to version 20130610204509."
  []
  (println "migrations.20130610204509-create-user-table up..."))

(defn down
  "Migrates the database down from version 20130610204509."
  []
  (println "migrations.20130610204509-create-user-table down..."))