import os
import sys
import subprocess

def format_folder_name(qno, problem_name):
    return f"{qno} - {problem_name.strip().replace(' ', '_')}"

def create_files(folder, code, description):
    os.makedirs(folder, exist_ok=True)
    
    # Save Java solution
    with open(os.path.join(folder, "Solution.java"), "w", encoding="utf-8") as f:
        f.write(code)
    
    # Save README
    readme_content = f"# Problem {folder}\n\n## Description\n\n{description.strip()}\n"
    with open(os.path.join(folder, "README.md"), "w", encoding="utf-8") as f:
        f.write(readme_content)

def git_add_commit_push(folder, commit_message):
    try:
        subprocess.run(["git", "add", folder], check=True)
        subprocess.run(["git", "commit", "-m", commit_message], check=True)
        subprocess.run(["git", "push"], check=True)
        print("✅ Successfully pushed to GitHub.")
    except subprocess.CalledProcessError as e:
        print(f"❌ Git error: {e}")

def main():
    # Input
    qno = input("Enter question number: ").strip()
    problem_name = input("Enter problem name: ").strip()
    print("Paste your Java code (end with 'END' on a new line):")
    code_lines = []
    while True:
        line = input()
        if line.strip() == "END":
            break
        code_lines.append(line)
    code = "\n".join(code_lines)

    print("Enter the problem description (end with 'END' on a new line):")
    desc_lines = []
    while True:
        line = input()
        if line.strip() == "END":
            break
        desc_lines.append(line)
    description = "\n".join(desc_lines)

    # Processing
    folder = format_folder_name(qno, problem_name)
    create_files(folder, code, description)
    git_add_commit_push(folder, f"Add solution for Q{qno} - {problem_name}")

if __name__ == "__main__":
    main()
