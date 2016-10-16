@Grab('org.xhtmlrenderer:core-renderer:R8')

import org.xhtmlrenderer.pdf.ITextRenderer
import org.w3c.dom.Document
import org.xml.sax.InputSource
import org.xhtmlrenderer.resource.XMLResource

def templatePdf = "/Users/makingdevs/Downloads/template.html"

def engine = new groovy.text.SimpleTemplateEngine()
def file = new File(templatePdf)
def text = file.text

def xhtmlWriter = new StringWriter()
def bindings = [message: "Hola inmundo", message_2: "Adios "]
engine.createTemplate(text).make(bindings).writeTo(xhtmlWriter)
xhtmlWriter.close()

f = new File("tmp.out")
f << xhtmlWriter.toString()

ITextRenderer renderer = new ITextRenderer()
renderer.setDocument(f)
renderer.layout()

def temporalFile= File.createTempFile(System.currentTimeMillis().toString(), ".pdf")
OutputStream os = new FileOutputStream(temporalFile)
renderer.createPDF(os)
println temporalFile
f.delete()
