/** From the VexFlow Tutorial
 * 
 */
const VF = Vex.Flow;
vextab = VexTabDiv;

function notate() {
	// Create an SVG renderer and attach it to the DIV element named "boo".
	var vf = new VF.Factory({renderer: {selector: 'div'}});
	var score = vf.EasyScore();
	var system = vf.System();

	system.addStave({
	  voices: [score.voice(score.notes('C#5/q, B4, A4, G#4'))]
	}).addClef('treble').addTimeSignature('4/4');

	vf.draw();
}

function notate(s) {
	// Create an SVG renderer and attach it to the DIV element named "boo".
	var vf = new VF.Factory({renderer: {selector: 'div'}});
	var score = vf.EasyScore();
	var system = vf.System();

	system.addStave({
	  voices: [score.voice(score.notes(s))]
	}).addClef('percussion').addTimeSignature('4/4');

	vf.draw();
}

function notateVexTab(s) {
	//$("#div").html(s);
	
	// Define options here for now
	options = "options font-size=14 space=0";
	tabstave = "tabstave notation=true tablature=false time=4/4 clef=percussion";
	notes = "notes :2S Bd/4 :qS Bd/4 :q ## | :8S Bd/4 Bu/4 :qS Bd-Bu-Bd/4 ^3^";
	
	VexTab = vextab.VexTab;
	Artist = vextab.Artist;
	Renderer = Vex.Flow.Renderer;

	// Create VexFlow Renderer from canvas element with id #boo.
	//renderer = new Renderer($('#canvas')[0], Renderer.Backends.CANVAS);

	// For SVG, you can use the following line (make sure #boo is a div element)
	renderer = new Renderer($('#div')[0], Renderer.Backends.SVG);

	// Initialize VexTab artist and parser.
	artist = new Artist(10, 10, 600, {scale: 0.8});
	vextab = new VexTab(artist);

	try {
	    // Parse VexTab music notation passed in as a string.
	    //vextab.parse("tabstave notation=true\n notes :q 4/4\n")
		//vextab.parse(s);
		vextab.parse(options+"\n"+tabstave+"\n"+s);

	    // Render notation onto canvas.
	    artist.render(renderer);
	} catch (e) {
	    console.log(e);
	}
}