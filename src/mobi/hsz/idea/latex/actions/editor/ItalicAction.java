/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 hsz Jakub Chrzanowski <jakub@hsz.mobi>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package mobi.hsz.idea.latex.actions.editor;

import com.intellij.psi.PsiElement;
import mobi.hsz.idea.latex.LatexBundle;
import mobi.hsz.idea.latex.psi.LatexInstruction;
import mobi.hsz.idea.latex.util.LatexIcons;
import org.jetbrains.annotations.NotNull;

/**
 * Editor action - italicize text.
 *
 * @author Jakub Chrzanowski <jakub@hsz.mobi>
 * @since 0.2
 */
public class ItalicAction extends WrapEditorAction {

    private static final String IDENTIFIER = "\\textit";

    /** Builds a new instance of {@link ItalicAction}. */
    public ItalicAction() {
        super(Type.ITALIC, LatexBundle.message("editor.italic"), LatexIcons.Editor.ITALIC);
    }

    @Override
    public boolean isMatching(@NotNull PsiElement element) {
        return element instanceof LatexInstruction && ((LatexInstruction) element).getIdentifier().getText().equals(IDENTIFIER);
    }

    @Override
    public String getLeftText() {
        return IDENTIFIER + "{";
    }

    @Override
    public String getRightText() {
        return "}";
    }

}
