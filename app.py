
from flask import Flask, request, send_file, render_template
import fitz  # PyMuPDF
import pandas as pd
from datetime import datetime, timedelta
import re
import os

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def upload_file():
    if request.method == 'POST':
        file = request.files['file']
        if file and file.filename.endswith('.pdf'):
            file_path = os.path.join("uploaded.pdf")
            file.save(file_path)
            output_path = process_pdf(file_path)
            return send_file(output_path, as_attachment=True)
    return render_template('upload.html')

def process_pdf(pdf_path):
    doc = fitz.open(pdf_path)
    text = "".join([page.get_text() for page in doc])
    doc.close()

    pattern = re.compile(r"(?P<name>[A-Za-z ]+)\s+(?P<in_time>\d{1,2}:\d{2}\s*[APMapm]{2})\s+(?P<out_time>\d{1,2}:\d{2}\s*[APMapm]{2})")
    matches = pattern.findall(text)

    data = []
    for match in matches:
        name, in_time, out_time = match
        try:
            in_dt = datetime.strptime(in_time.strip().upper(), "%I:%M %p")
            out_dt = datetime.strptime(out_time.strip().upper(), "%I:%M %p")
            if out_dt < in_dt:
                out_dt += timedelta(days=1)
            hours = (out_dt - in_dt).total_seconds() / 3600

            status = "P" if hours > 6 else "P/2"
            ot = ""
            if hours > 12:
                extra = hours - 12 - 0.25
                if extra >= 1: ot += "1H"
                if extra >= 2: ot += " 2H"
                if extra >= 3: ot += " 3H"
            if in_dt.strftime("%H:%M") == "07:45":
                ot += " OT"

            data.append([name.strip(), in_time.strip(), out_time.strip(), round(hours, 2), status, ot.strip()])
        except:
            continue

    df = pd.DataFrame(data, columns=["Employee Name", "In Time", "Out Time", "Hours Worked", "Attendance", "Overtime"])
    output_file = "attendance_report.xlsx"
    df.to_excel(output_file, index=False)
    return output_file

if __name__ == '__main__':
    app.run(debug=True)
