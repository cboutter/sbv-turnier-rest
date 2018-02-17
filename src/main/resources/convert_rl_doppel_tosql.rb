require 'csv'

disz = ARGV[0]

target = open("meldungen_import_#{disz}.sql", 'w')
target.truncate(0)

open_partners_sm16 = {}
open_partners_rlt17 = {}
open_partners_sm17 = {}

CSV.foreach("Rangliste_VL_#{disz}.csv", quote_char: '"', col_sep: ',', row_sep: :auto, headers: true) do |row|
  name = row['Nachname']
  vorname = row['Vorname']
  platz_sm16 = row['Platz SM 16']
  platz_rlt = row['Platz RLT 17']
  platz_sm17 = row['Platz SM 17']

  if platz_sm16 != nil then
    if open_partners_sm16.has_key? platz_sm16 then
      partner_row = open_partners_sm16[platz_sm16]
      partner_name = partner_row['Nachname']
      partner_vorname = partner_row['Vorname']

      target.write("insert into meldung (spieler_id, partner_id, turnier_id, disziplin, meldung_type, end_platzierung) select s1.id as s_id, s2.id as partner_id, 2, '#{disz}', 'doppel', #{platz_sm16} from spieler s1, spieler s2 where s1.name = '#{name}' and s1.vorname = '#{vorname}' and s2.name = '#{partner_name}' and s2.vorname = '#{partner_vorname}';\n")
      target.write("insert into meldung (spieler_id, partner_id, turnier_id, disziplin, meldung_type, end_platzierung) select s2.id as s_id, s1.id as partner_id, 2, '#{disz}', 'doppel', #{platz_sm16} from spieler s1, spieler s2 where s1.name = '#{name}' and s1.vorname = '#{vorname}' and s2.name = '#{partner_name}' and s2.vorname = '#{partner_vorname}';\n")

      open_partners_sm16.delete(platz_sm16)
    else
      open_partners_sm16[platz_sm16] = row
    end
  end

  if platz_rlt != nil then
    if open_partners_rlt17.has_key? platz_rlt then
      partner_row = open_partners_rlt17[platz_rlt]
      partner_name = partner_row['Nachname']
      partner_vorname = partner_row['Vorname']

      target.write("insert into meldung (spieler_id, partner_id, turnier_id, disziplin, meldung_type, end_platzierung) select s1.id as s_id, s2.id as partner_id, 3, '#{disz}', 'doppel', #{platz_rlt} from spieler s1, spieler s2 where s1.name = '#{name}' and s1.vorname = '#{vorname}' and s2.name = '#{partner_name}' and s2.vorname = '#{partner_vorname}';\n")
      target.write("insert into meldung (spieler_id, partner_id, turnier_id, disziplin, meldung_type, end_platzierung) select s2.id as s_id, s1.id as partner_id, 3, '#{disz}', 'doppel', #{platz_rlt} from spieler s1, spieler s2 where s1.name = '#{name}' and s1.vorname = '#{vorname}' and s2.name = '#{partner_name}' and s2.vorname = '#{partner_vorname}';\n")

      open_partners_rlt17.delete(platz_rlt)
    else
      open_partners_rlt17[platz_rlt] = row
    end
  end

  if platz_sm17 != nil then
    if open_partners_sm17.has_key? platz_sm17 then
      partner_row = open_partners_sm17[platz_sm17]
      partner_name = partner_row['Nachname']
      partner_vorname = partner_row['Vorname']

      target.write("insert into meldung (spieler_id, partner_id, turnier_id, disziplin, meldung_type, end_platzierung) select s1.id as s_id, s2.id as partner_id, 4, '#{disz}', 'doppel', #{platz_sm17} from spieler s1, spieler s2 where s1.name = '#{name}' and s1.vorname = '#{vorname}' and s2.name = '#{partner_name}' and s2.vorname = '#{partner_vorname}';\n")
      target.write("insert into meldung (spieler_id, partner_id, turnier_id, disziplin, meldung_type, end_platzierung) select s2.id as s_id, s1.id as partner_id, 4, '#{disz}', 'doppel', #{platz_sm17} from spieler s1, spieler s2 where s1.name = '#{name}' and s1.vorname = '#{vorname}' and s2.name = '#{partner_name}' and s2.vorname = '#{partner_vorname}';\n")

      open_partners_sm17.delete(platz_sm17)
    else
      open_partners_sm17[platz_sm17] = row
    end
  end

end