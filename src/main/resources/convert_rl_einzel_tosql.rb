require 'csv'

disz = ARGV[0]

target = open("meldungen_import_#{disz}.sql", 'w')
target.truncate(0)

CSV.foreach("Rangliste_VL_#{disz}.csv", quote_char: '"', col_sep: ',', row_sep: :auto, headers: true) do |row|
  name = row['Nachname']
  vorname = row['Vorname']
  platz_sm16 = row['Platz SM 16']
  platz_rlt = row['Platz RLT 17']
  platz_sm17 = row['Platz SM 17']

  if platz_sm16 != nil then
    target.write("insert into meldung (einzel_spieler_id, turnier_id, disziplin, meldung_type, end_platzierung) select id, 2, '#{disz}', 'einzel', #{platz_sm16} from spieler where name = '#{name}' and vorname = '#{vorname}';\n")
  end

  if platz_rlt != nil then
    target.write("insert into meldung (einzel_spieler_id, turnier_id, disziplin, meldung_type, end_platzierung) select id, 3, '#{disz}', 'einzel', #{platz_rlt} from spieler where name = '#{name}' and vorname = '#{vorname}';\n")
  end

  if platz_sm17 != nil then
    target.write("insert into meldung (einzel_spieler_id, turnier_id, disziplin, meldung_type, end_platzierung) select id, 4, '#{disz}', 'einzel', #{platz_sm17} from spieler where name = '#{name}' and vorname = '#{vorname}';\n")
  end

end