// ** I18N

// Calendar ES (spanish) language
// Author: Mihai Bazon, <mihai_bazon@yahoo.com>
// Updater: Servilio Afre Puentes <servilios@yahoo.com>
// Updated: 2004-06-03
// Encoding: utf-8
// Distributed under the same terms as the calendar itself.

// For translators: please use UTF-8 if possible.  We strongly believe that
// Unicode is the answer to a real internationalized world.  Also please
// include your contact information in the header, as can be seen above.

// full day names
Calendar._DN = new Array
("Diumenge",
 "Dilluns",
 "Dimarts",
 "Dimecres",
 "Dijous",
 "Divendres",
 "Dissabte",
 "Diumenge");

// Please note that the following array of short day names (and the same goes
// for short month names, _SMN) isn't absolutely necessary.  We give it here
// for exemplification on how one can customize the short day names, but if
// they are simply the first N letters of the full name you can simply say:
//
//   Calendar._SDN_len = N; // short day name length
//   Calendar._SMN_len = N; // short month name length
//
// If N = 3 then this is not needed either since we assume a value of 3 if not
// present, to be compatible with translation files that were written before
// this feature.

// short day names
Calendar._SDN = new Array
("Dg",
 "Dl",
 "Dm",
 "Dc",
 "Dj",
 "Dv",
 "Ds",
 "Dg");

// First day of the week. "0" means display Sunday first, "1" means display
// Monday first, etc.
Calendar._FD = 1;

// full month names
Calendar._MN = new Array
("Gener",
 "Febrer",
 "Mar�",
 "Abril",
 "Maig",
 "Juny",
 "Juliol",
 "Agost",
 "Setembre",
 "Octubre",
 "Novembre",
 "Desembre");

// short month names
Calendar._SMN = new Array
("Gen",
 "Feb",
 "Mar�",
 "Abr",
 "Mai",
 "Jun",
 "Jul",
 "Ago",
 "Set",
 "Oct",
 "Nov",
 "Des");

// tooltips
Calendar._TT = {};
Calendar._TT["INFO"] = "Sobre el calendari";

Calendar._TT["ABOUT"] =
"Selector DHTML de Fecha/Hora\n" +
"(c) dynarch.com 2002-2005 / Author: Mihai Bazon\n" + // don't translate this this ;-)
"Para conseguir la �ltima versi�n visite: http://www.dynarch.com/projects/calendar/\n" +
"Distribuido bajo licencia GNU LGPL. Visite http://gnu.org/licenses/lgpl.html para m�s detalles." +
"\n\n" +
"Selecci� de data:\n" +
"- Use els botons \xab, \xbb per a seleccionar l'any\n" +
"- Use els botons " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " per a seleccionar el mes\n" +
"- Mantinga polsat el ratol� en qualsevol d'estos botons per a una selecci� r�pida.";
Calendar._TT["ABOUT_TIME"] = "\n\n" +
"Selecci� d'hora:\n" +
"- Polse en qualsevol de les parts de l'hora per a incrementar-la\n" +
"- o polse les maj�scules mentres fa clic per a decrementarla\n" +
"- o fa�a clic i arrossegament el ratol� per a una selecci� m�s r�pida.";

Calendar._TT["PREV_YEAR"] = "Any anterior (mantindre per a men�)";
Calendar._TT["PREV_MONTH"] = "Mes anterior (mantindre per a men�)";
Calendar._TT["GO_TODAY"] = "Anar a hui";
Calendar._TT["NEXT_MONTH"] = "Mes seg�ent (mantindre per a men�)";
Calendar._TT["NEXT_YEAR"] = "Any seg�ent (mantindre per a men�)";
Calendar._TT["SEL_DATE"] = "Seleccionar data";
Calendar._TT["DRAG_TO_MOVE"] = "Arrossegar per a moure";
Calendar._TT["PART_TODAY"] = " (hui)";

// the following is to inform that "%s" is to be the first day of week
// %s will be replaced with the day name.
Calendar._TT["DAY_FIRST"] = "Fer %s primer dia de la setmana";

// This may be locale-dependent.  It specifies the week-end days, as an array
// of comma-separated numbers.  The numbers are from 0 to 6: 0 means Sunday, 1
// means Monday, etc.
Calendar._TT["WEEKEND"] = "0,6";

Calendar._TT["CLOSE"] = "Tancar";
Calendar._TT["TODAY"] = "Hui";
Calendar._TT["TIME_PART"] = "(Maj�scula-)Clic o arrossegament per a canviar valor";

// date formats
Calendar._TT["DEF_DATE_FORMAT"] = "%d/%m/%Y";
Calendar._TT["TT_DATE_FORMAT"] = "%A, %e de %B de %Y";

// Calendar._TT["WK"] = "sem";
Calendar._TT["WK"] = "setm";
Calendar._TT["TIME"] = "Hora:";
