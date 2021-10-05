package fr.mylocalphone.sanbot.provider;

import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsProvider;

import java.io.FileNotFoundException;

/**
 * Created by suppo on 12/03/2018.
 */

public class SanbotFilesProvider extends DocumentsProvider {
    @Override
    public Cursor queryRoots(String[] strings) throws FileNotFoundException {
        return null;
    }

    @Override
    public Cursor queryDocument(String s, String[] strings) throws FileNotFoundException {
        return null;
    }

    @Override
    public Cursor queryChildDocuments(String s, String[] strings, String s1) throws FileNotFoundException {
        return null;
    }

    @Override
    public ParcelFileDescriptor openDocument(String s, String s1, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return null;
    }

    @Override
    public boolean onCreate() {
        return false;
    }
}
